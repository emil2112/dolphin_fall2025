# The Dolphin JPA Exercise

## Gode ting at huske på ifm JPA og Lombok

1. Opret config.properties i `resources`

```
DB_NAME=name_of_your_db
DB_USERNAME=postgres
DB_PASSWORD=postgres
```

2. Opret en database i postgres

3. Opret en EntityManagerFactory i Main og kær for at lave tabellerne

```java
EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
```

## Lombok annotationer

```plaintext
@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@ToString.Exclude
@EqualsAndHashCode.Exclude
```

## JPA annotationer

```plaintext
@Entity
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@OneToOne(mappedBy="person", cascade = CascadeType.ALL)
@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
```