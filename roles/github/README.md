# devxp-ansible-collection-wsl.git

This role installs Github cli and dxp plugin

## Variables

See [defaults.yml](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/git/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Install GitHub CLI
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: github
```