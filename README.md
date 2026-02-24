
# Learning Redis

Personal learning repository for Redis - an in-memory data structure store used as a database, cache, and message broker. Contains notes, code examples, and hands-on experiments.

## Features
- Basic Redis commands (SET, GET, DEL, etc.)
- Data structures: Strings, Lists, Sets, Hashes, Sorted Sets
- Pub/Sub messaging
- Persistence (RDB, AOF)
- Caching patterns and TTL
- Spring Boot + Redis integration examples

## Quick Start

1. **Install Redis** (Docker recommended):
   ```bash
   docker run --name redis-learn -p 6379:6379 -d redis:latest
   ```

2. **Clone and explore**:
   ```bash
   git clone https://github.com/KHOJAH/Learning-Redis.git
   cd Learning-Redis
   ```

3. **Connect with Redis CLI**:
   ```bash
   redis-cli
   > SET greeting "Hello Redis!"
   > GET greeting
   ```

## Table of Contents
- [Basic Operations](./basic/)
- [Data Structures](./structures/)
- [Spring Boot Examples](./spring-boot/)
- [Advanced Topics](./advanced/)

## Example Usage

**Caching with TTL**:
```bash
SETEX user:123:session "eyJhbGciOiJIUzI1NiIs..." 3600
```

**List as Queue**:
```bash
LPUSH jobs:pending "process-user-123"
RPOP jobs:pending
```

## Spring Boot Setup
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

```java
@RedisHash("users")
public class User {
    @Id private String id;
    private String name;
    // getters/setters
}
```

## Development Environment
- Redis 7.x
- Java 17+ / Spring Boot 3.x
- Docker
- RedisInsight (GUI client)

## Learning Path
1. Basic key-value operations
2. Advanced data structures
3. Transactions & Lua scripts
4. Clustering & replication
5. Redis modules (JSON, Search)

## Contributing
1. Fork the repo
2. Add your Redis examples/notes
3. Submit PR with clear descriptions

## License
MIT License - feel free to use and share!

---

*Built by Ramez Khojah - Computer Engineer & Pop Science YouTuber*
```
