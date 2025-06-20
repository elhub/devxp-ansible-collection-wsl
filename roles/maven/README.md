# devxp-ansible-collection-wsl.maven

- [maven](https://maven.apache.org/)

This role installs Apache Maven locally, allowing you to build and manage Java projects (including TeamCity DSL) with version consistency.
Maven automates your build process and handles dependency management efficiently.

## Usage

Include the role in your playbook as shown below:

```yaml
- name: Install Apache Maven
  hosts: localhost
  collections:
    - elhub.wsl
  roles:
    - role: maven
```

Alternatively, it can be imported as part of a playbook:

```yaml
- ansible.builtin.import_role:
    name: elhub.wsl.maven
  tags:
    - maven
```
