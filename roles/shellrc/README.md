# Shell Run Commands (shrc)

This role sets up a `shrc.d` directory that we use to customize the shell
environment for users. It allows other roles to add shell configuration files
without interfering with the regular rc files.

Supported shells:

* bash
* zsh

We ensure that the parts in the `shrc.d` directory are sourced by the shell when
it starts by adding a small snippet/loop in `.zshrc` and `.bashrc`.

The different shells will source the files in the `shrc.d` directory based on
the file extensions.

* `.sh` - sourced by both `bash` and `zsh`
* `.bash` - sourced by `bash`
* `.zsh` - sourced by `zsh`

Files are read in lexicographical order, so we generally prefix with a number to
ensure the correct order.
