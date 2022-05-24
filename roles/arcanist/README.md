# ansible-collection-wsl.arcanist

This role installs [arcanist](https://secure.phabricator.com/book/phabricator/article/arcanist/), the command-line
interface to [Phabricator](https://secure.phabricator.com/). Phabricator is used by Elhub for code reviews.

## Variables

See [defaults.yml](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/arcanist/defaults/main.yml).

## Examples

Run the role using a playbook as follows:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: arcanist
```

To install with a different install path:

```yaml
- name: Deploy devxp
  hosts:
    - localhost
  collections:
    - elhub_devxp.ansible_collection_wsl
  roles:
    - role: arcanist
      vars:
        install_path: "{{ ansible_env.HOME }}/.local/arcanist"
```
