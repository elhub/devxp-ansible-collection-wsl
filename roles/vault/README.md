# ansible-collection-wsl.molecule

This role installs [vault](https://www.vaultproject.io/) on WSL.

## Variables

See [defaults](defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: vault
```
