#!/usr/bin/env bash
# {{ ansible_managed }}
#
# This is a base hook for git.
#
# The main thing we are trying to achieve is that we want to have global and local hooks scripts running at the same time.
# By "local", we mean the hooks that are in the .git/hooks directory of the repository.
# By "global", we mean the hooks that are in the configured `core.hooksPath` directory.
#
# The current state of git is that if the `core.hooksPath` is set, the local hooks are ignored.
#
# This script should be templated and copied to the `core.hooksPath` directory under the <hook name>
# <hook name> is something like "pre-commit" or "commit-msg".
#
# When invoked, the script then call the local hooks and then any "global" hooks.
# Global hooks must be placed in the `core.hooksPath` directory under a <hook name>.d directory.
#
# So, as an example, if the hook name is pre-commit, then it will run:
#  * <repository>/.git/hooks/pre-commit
#  * <core.hooksPath>/pre-commit.d/*
#
# This script is inspired by the discussion in
# https://github.com/majutsushi/etc/commit/e62904088c698e064c17522d54dff91b629ee253#diff-53b7e445a85984949f551c277d4cc4ee9682287cb234e075e6d352be887e7494

set -eEu -o pipefail
[[ -n ${DEBUG:-} ]] && set -x
shopt -s inherit_errexit

STD_IN=$(cat)
HOOK_NAME=$(basename "$0")
# SCRIPT_DIR based on https://stackoverflow.com/a/246128
SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

# We need to explicitly set the GIT_DIR environment variable to the .git directory
# Fallback in case we are not in a repo (like when cloning)
_GIT_DIR=$(git rev-parse --git-dir 2>/dev/null || echo -n "${GIT_DIR:-}")
export GIT_DIR=$_GIT_DIR


if [ -x "${GIT_DIR}/hooks/${HOOK_NAME}" ]; then
  echo "$STD_IN" | "${GIT_DIR}/hooks/${HOOK_NAME}" "$@" || exit $?
fi

if [[ -d "${SCRIPT_DIR}/${HOOK_NAME}.d" ]]; then
    for HOOK_D in "${SCRIPT_DIR}/${HOOK_NAME}.d/"*; do
        if [ -x "$HOOK_D" ]; then
            echo "$STD_IN" | "$HOOK_D" "$@" || exit $?
        fi
    done
fi
