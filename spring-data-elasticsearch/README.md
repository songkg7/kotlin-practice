# Spring data Elasticsearch

Spring Data Elasticsearch is a Spring module that provides integration
with [Elasticsearch](http://www.elasticsearch.org/).

## Getting started

### Docker

The easiest way to get started with Elasticsearch is to use the provided docker compose file.

#### Single node

```bash
docker compose up
```

#### Multi node

```bash
docker compose -f docker-compose-cluster.yml up
```

if you want docker compose details, please refer
to [docker compose documentation](https://docs.docker.com/compose/reference/overview/)
