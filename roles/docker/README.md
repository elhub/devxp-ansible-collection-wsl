# devxp-ansible-collection-wsl.docker

This role the docker client in WSL. You can choose to install the Windows backend to docker in addition, but it is not
necessary for the use of docker; you can set up a docker daemon directly in WSL using ```sudo dockerd``` when you need
it.

## Variables

N/A.

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.wsl
  roles:
    - role: docker
```
