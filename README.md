# devxp-ansible-collection-wsl

[<img src="https://img.shields.io/badge/repo-github-blue" alt="">](<https://github.com/elhub/devxp-ansible-collection-wsl)
[<img src="https://img.shields.io/badge/issues-jira-orange" alt="">](https://jira.elhub.cloud/projects/TD/issues)
[<img src="https://teamcity.elhub.cloud/app/rest/builds/buildType:(id:DevXP_AnsibleCollectionWsl)/statusIcon" alt="">](https://teamcity.elhub.cloud/buildConfiguration/<!--TODO Add TeamCity project ID here -->)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Adevxp-ansible-collection-wsl&metric=alert_status" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Adevxp-ansible-collection-wsl)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Adevxp-ansible-collection-wsl&metric=ncloc" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Adevxp-ansible-collection-wsl)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Adevxp-ansible-collection-wsl&metric=bugs" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Adevxp-ansible-collection-wsl)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Adevxp-ansible-collection-wsl&metric=vulnerabilities" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Adevxp-ansible-collection-wsl)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Adevxp-ansible-collection-wsl&metric=coverage" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Adevxp-ansible-collection-wsl)

## Table of Contents

* [Table of Contents](#table-of-contents)
* [Breaking changes for Ubuntu 24.04 and devxp-wsl](#breaking-changes-for-ubuntu-2404-and-devxp-wsl)
* [About](#about)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
  * [From ansible playbooks](#from-ansible-playbooks)
  * [From command line](#from-command-line)
* [Testing](#testing)
  * [Molecule](#molecule)
  * [Testing with Docker](#testing-with-docker)
* [Contributing](#contributing)
* [Owners](#owners)
* [License](#license)

## Breaking changes for Ubuntu 24.04 and devxp-wsl

> [!WARNING]
> This collection has gotten some breaking changes due to the move
> from Ubuntu 22.04 to Ubuntu 24.04 and `devxp-linux`/`plat-intune-wsl` to `devxp-wsl`.
> If you are on Ubuntu 22.04, use the `ubuntu22` branch.

## About

This ansible collection comprises resources that facilitate an opinionated setup of the Linux/WSL components for a
a Windows developer workstation at Elhub.

The ansible collection contains:

* The base [role](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/base). This bootstraps core packages,
  creates base directories, and sets up ssh-agent
* Roles for setting up common tools such as [git](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/git),
  [docker](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/docker),
  [molecule](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/molecule)
* Roles for setting up development environments for different programming languages/purposes such as
  [ansible](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/ansible),
  [java](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/java), and
  [kotlin](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/kotlin), and
  [node/javascript](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/node), and
  [python](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/python).
* Roles for setting up scripts and apps used by the development team such as
  [git utils](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/git_utils), and
  [adr](https://github.com/elhub/devxp-ansible-collection-wsl/tree/main/roles/adr).

## Getting Started

### Prerequisites

Requires:
- [WSL2](https://docs.microsoft.com/en-us/windows/wsl/install) with the Ubuntu linux distribution.
- Ansible installed in the linux installation

### Installation

To install the collection from git, use the following in your requirements.yml
```yaml
---
collections:
   - name: git@github.com:elhub/devxp-ansible-collection-wsl.git
     type: git
     version: main
```

You can also install manually by using the following ansible-galaxy command

```bash
ansible-galaxy collection install git+https://github.com/elhub/devxp-ansible-collection-wsl
```

## Usage

### From ansible playbooks

The roles in this playbook are shared by the ansible playbooks used to set up the developer PC's; see e.g.,
[devxp-linux](https://github.com/elhub/devxp-linux).

The base role is used to bootstrap the environment for the other roles.

* **base** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/base/README.md)

For details and examples for the other individual roles:

* **adr** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/adr/README.md)
* **ansible** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/ansible/README.md)
* **docker** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/docker/README.md)
* **git** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/git/README.md)
* **git_utils** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/git_utils/README.md)
* **java** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/java/README.md)
* **kotlin** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/kotlin/README.md)
* **molecule** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/molecule/README.md)
* **node** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/node/README.md)
* **python** role: See the documentation [here](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/roles/python/README.md)

### From command line

Install the collection using the [instructions above](#installation).
You can run the roles from the command line using the following command.
Replace `elhub.wsl.restish` with the role you want to run.

```bash
ansible -m import_role -e "{ 'ansible_env' : { 'HOME' : '$HOME' }}" -a name=elhub.wsl.restish localhost
```

If the role requires sudo/root, add `--ask-become-pass` to the command.

## Testing

### Molecule

The roles can be tested using molecule. Ensure you have python, ansible, docker, and molecule installed (the roles in this collection should ensure that your environment is set up correctly) and a docker backend running. Then change to the role you wish to validate and run:

```bash
molecule test
```

### Testing with Docker

While molecule is great for "unit testing", it can be desirable to test new things in a 'test environment', before adding these roles to a playbook that sets up your main workstation. For this we build a minimal Docker image which can then used to create container and validate things work as expected.

To build the image run: `docker build -f test/Dockerfile -t wsl-test:latest .`

You might want to install only certain roles from this collection, or maybe set some specific vars for any given role. In this case modify the [test.yml](test/test.yml) accordingly before building the image.

Then you can ssh into the container with `docker run -it wsl-test:latest` and test things out before you install them on your main system.

## Contributing

Contributing, issues and feature requests are welcome. See the
[Contributing](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/CONTRIBUTING.md) file.

## Owners

This project is developed by [Elhub](https://www.elhub.no). For the specific development group responsible for this
code, see the [Codeowners](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/CODEOWNERS) file.

## License

This project is [MIT](https://github.com/elhub/devxp-ansible-collection-wsl/blob/main/LICENSE.md) licensed.
