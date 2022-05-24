# ansible-collection-wsl.adr

This role adds [ADR-J](https://github.com/adoble/adr-j), a java-based command-line tool for working with 
[Architecture Decision Records](https://cognitect.com/blog/2011/11/15/documenting-architecture-decisions) to your
environment.

This role downloads a zip file with the compiled packages from a repo (by default, Elhub's internal repo). To make use
of this externally, you will need to provide your own jar files.

## Variables

See [defaults.yml](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/adr/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: adr
```

To install from an external repository:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub_devxp.ansible_collection_wsl
  roles:
    - role: adr
      vars:
        repository: https://example.com/repos/adr-j
```
