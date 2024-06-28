# devxp-ansible-collection-wsl.base

This role bootstraps core packages, creates base directories and sets up the ssh-agent. It should generally be
run before any other roles in this collection are run.

## Variables

See [defaults.yml](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/base/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: base
```

To install with _htop_ added as one of the base packages:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub_devxp.ansible_collection_wsl
  roles:
    - role: base
      vars:
        config_packages:
          - htop
```
