# Spring Data JDBC Playground

## What this project shows
- A simple blog domain with Authors, Posts, and Comments
- Two relationship styles in Spring Data JDBC:
  - Aggregate children: Post owns a collection of Comment (same aggregate)
  - Aggregate reference: Post references an Author via `AggregateReference<Author, Integer>` (separate aggregate)
- Basic REST endpoints to read data
- Automatic schema initialization and sample data seeding at startup


## Domain model (simplified)
- Author (aggregate root)
  - id, firstName, lastName, email, username
- Post (aggregate root)
  - id, title, content, createdAt, updatedAt
  - author: `AggregateReference<Author, Integer>` (many posts can reference one author)
  - comments: `Set<Comment>` (owned children in the Post aggregate)
- Comment (value-like entity within Post aggregate)
  - name, content, publishedAt, updatedAt


## Notes on Spring Data JDBC mapping
- Aggregate reference (`AggregateReference<Author, Integer>`) stores only the foreign key (author id) within `post.author` column.
- Aggregate children (Comments) are stored in a `comment` table with a foreign key `post` pointing to the owning Post.
- This project intentionally returns `null` for not-found resources to keep the example minimal. In a production app, prefer 404 responses.
