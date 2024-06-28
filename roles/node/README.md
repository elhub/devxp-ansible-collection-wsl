# devxp-ansible-collection-wsl.adr

This role installs [nvm](https://github.com/nvm-sh/nvm) and [nodejs](https://nodejs.org/en/) to your environment.

## Variables

See [defaults.yml](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/adr/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: node
```
