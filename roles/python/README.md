# devxp-ansible-collection-wsl.python

This role installs Python 3 on WSL and sets it to the default. It also installs various necessary supporting packages.

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
    - role: python
```
