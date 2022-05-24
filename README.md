# ansible-collection-wsl

[<img src="https://img.shields.io/badge/repo-github-blue" alt="">](<https://github.com/elhub/ansible-collection-wsl)
[<img src="https://img.shields.io/badge/issues-jira-orange" alt="">](https://jira.elhub.cloud/projects/TD/issues)
[<img src="https://teamcity.elhub.cloud/app/rest/builds/buildType:(id:<!--TODO Add TeamCity project ID here -->)/statusIcon" alt="">](https://teamcity.elhub.cloud/buildConfiguration/<!--TODO Add TeamCity project ID here -->)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Aansible-collection-wsl&metric=alert_status" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Aansible-collection-wsl)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Aansible-collection-wsl&metric=ncloc" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Aansible-collection-wsl)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Aansible-collection-wsl&metric=bugs" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Aansible-collection-wsl)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Aansible-collection-wsl&metric=vulnerabilities" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Aansible-collection-wsl)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.devxp%3Aansible-collection-wsl&metric=coverage" alt="">](https://sonar.elhub.cloud/dashboard?id=no.elhub.devxp%3Aansible-collection-wsl)

## Table of Contents

* [About](#about)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Testing](#testing)
* [Contributing](#contributing)
* [Owners](#owners)
* [License](#license)


## About

This ansible collection comprises resources that facilitate an opinionated setup of the Linux/WSL components for a
a Windows developer workstation at Elhub.

The ansible collection contains:

* The base [role](https://github.com/elhub/ansible-collection-wsl/tree/main/roles/base). This bootstraps core packages,
creates base directories, and sets up ssh-agent
* Roles for setting up common tools such as [git](https://github.com/elhub/ansible-collection-wsl/tree/main/roles/git)
* A role for setting up [arcanist](https://github.com/elhub/ansible-collection-wsl/tree/main/roles/arcanist), a tool
used by our developers for code reviews

## Getting Started

### Prerequisites

Requires:
- [WSL2](https://docs.microsoft.com/en-us/windows/wsl/install) with the Ubuntu linux distribution.
- Ansible installed in the linux installation

## Usage

To install the collection from git, use the following in your requirements.yml
```yaml
---
collections:
   - name: git@github.com:elhub/ansible-collection-wsl.git
     type: git
     version: main
```

The roles in this playbook are shared by the ansible playbooks used to set up the developer PC's; see e.g.,
[devxp-linux](https://github.com/elhub/devxp-linux).

For details and examples for the individual roles:

* **base** role: See the documentation [here](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/base/README.md)
* **adr** role: See the documentation [here](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/adr/README.md)
* **ansible** role: See the documentation [here](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/ansible/README.md)
* **arcanist** role: See the documentation [here](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/arcanist/README.md)
* **git** role: See the documentation [here](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/git/README.md)
* **git_utils** role: See the documentation [here](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/git_utils/README.md)
* **node** role: See the documentation [here](https://github.com/elhub/ansible-collection-wsl/blob/main/roles/node/README.md)

## Contributing

Contributing, issues and feature requests are welcome. See the
[Contributing](https://github.com/elhub/ansible-collection-wsl/blob/main/CONTRIBUTING.md) file.

## Owners

This project is developed by [Elhub](https://wwww.elhub.no). For the specific development group responsible for this
code, see the [Codeowners](https://github.com/elhub/ansible-collection-wsl/blob/main/CODEOWNERS) file.

## License

This project is [MIT](https://github.com/elhub/ansible-collection-wsl/blob/main/LICENSE.md) licensed.
