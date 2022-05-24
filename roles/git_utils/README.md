# ansible-collection-wsl.git_utils

This role installs git utility scripts for Elhub.

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
    - role: git_utils
```
