# incloo

Incloo é uma plataforma de recrutamento e seleção da Challenge da Everymind de 2023 do 4º ano do curso de Sistemas de
Informação da FIAP

---

## Sumário

1. [Instruções de uso](#instruções-de-uso)
    1. [Rodar todos os módulos](#rodar-todos-os-módulos)

---

## Instruções de uso

Para este projeto, você precisará dos seguintes itens instalados na sua máquina:

- JDK 17
- Maven (Opcional - o projeto possui um wrapper)
- [Rancher Desktop](https://rancherdesktop.io/), [Podman Desktop](https://podman-desktop.io/)
  ou [Docker Desktop](https://www.docker.com/products/docker-desktop/)

---

### Rodar todos os módulos

Siga o passo a passo a seguir para buildar os módulos, criar suas respectivas imagens e rodar o projeto:

**Obs.:** Use `nerdctl`/`docker` se estiver usando Rancher Desktop com containerd/dockerd, `podman` se estiver usando
Podman Desktop, ou `docker` se estiver usando Docker Desktop.

1. Buildar projeto:

```shell
./mvnw clean package -DskipTests -f pom.xml
```

2. Criar todas as imagens dos módulos:

```shell 
nerdctl compose -f ./docker-compose.yaml build
```

3. Subir os contêineres:

```shell
nerdctl compose -f ./docker-compose.yaml up -d
```

###### Flags

- `-f`: indica o caminho dos arquivos de configuração `pom.xml` e `docker-compose.yaml`
- `-d`: separa o contêiner em um processo independente
