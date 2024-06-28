# devxp-ansible-collection-wsl.kotlin

This role install the Kotlin SDK.

## Variables

See [defaults.yml](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/kotlin/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: kotlin
```

To install an older Kotlin SDK and set that to be default:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub_devxp.ansible_collection_wsl
  roles:
    - role: kotlin
      vars:
        sdkman_additional_packages:
          - { sdk: kotlin, version: 1.4.0 }
        sdkman_defaults:
          kotlin: 1.4.0
```
