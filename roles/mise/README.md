# devxp-ansible-collection-wsl.mise

- [mise-en-place](https://mise.jdx.dev/)

This role install mise-en-place. With this tool, you can use the exact version of any language or tool you need, switch between different versions, and specify versions for each project. 

Mise-en-place is activated using `mise activate` and not shims. According to its docs, this is the recommended way for interactive shells: 
*  [Activate mise](https://mise.jdx.dev/getting-started.html#_2-activate-mise)
* [Pros/Cons with shims](https://jdx.dev/posts/2024-04-13-shims-how-they-work-in-mise-en-place/#proscons)

## Usage 

Run the role using a playbook as follows: 
```yaml
- name: Install mise-en-place
  hosts:
    - localhost
  collections:
    - elhub.ansible_collection_wsl
  roles:
    - role: mise
```

To import the role as a part of a playbook: 
```yaml
- ansible.builtin.import_role:
    name: elhub.wsl.mise
  tags:
    - mise 
```
