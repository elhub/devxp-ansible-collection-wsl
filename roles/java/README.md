# devxp-ansible-collection-wsl.java

This role install the Java SDK.

## Variables

See [defaults.yml](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/java/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.wsl
  roles:
    - role: java
```

To install with additional Java sdks, and setting that to default:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.wsl
  roles:
    - role: base
      vars:
        sdkman_additional_packages:
          - { sdk: java, version: 17.0.123-open }
        sdkman_defaults:
          java: 17.0.123-open
```
