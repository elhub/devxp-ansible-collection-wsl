# devxp-ansible-collection-wsl.linters

This role install is used to install the standard set of linters on the WSL dev box. It can be configured to
only install a subset of these linters.

## Variables

See [defaults.yml](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/linters/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: linters
```

To change which linters are installed:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub_devxp.ansible_collection_wsl
  roles:
    - role: linters
      vars:
        default_linters:
          - ansible_lint
          - yamllint
```
