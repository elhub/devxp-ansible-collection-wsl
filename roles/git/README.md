# ansible-collection-wsl.git

This role streamlines the git installation. In particular, it ensures that everyone is set up with username/e-mail
and consistent EOL and autocrlf settings.

## Variables

See [defaults.yml](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/git/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: git
```

To install with another git hooks path:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub_devxp.ansible_collection_wsl
  roles:
    - role: git
      vars:
        git_hooks_path: "{{ ansible_env.HOME }}/.git-hooks"
```
