# ansible-collection-wsl.ansible

This role installs ansible. It ensures that the install of ansible is done according to our conventions and adds
a couple of required pip packages.

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
    - role: ansible
```
