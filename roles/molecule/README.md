# ansible-collection-wsl.molecule

This role installs molecule and its supporting libraries on WSL.

## Variables

N/A.

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: molecule
```
