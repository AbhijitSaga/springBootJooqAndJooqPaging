/*
 * This file is generated by jOOQ.
 */
package com.tej.JooQDemo.jooq.sample.model.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  title;
    private String  author;

    public Book() {}

    public Book(Book value) {
        this.id = value.id;
        this.title = value.title;
        this.author = value.author;
    }

    public Book(
        Integer id,
        String  title,
        String  author
    ) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    /**
     * Getter for <code>test.book.ID</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>test.book.ID</code>.
     */
    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>test.book.TITLE</code>.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter for <code>test.book.TITLE</code>.
     */
    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Getter for <code>test.book.AUTHOR</code>.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Setter for <code>test.book.AUTHOR</code>.
     */
    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        }
        else if (!author.equals(other.author))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        result = prime * result + ((this.author == null) ? 0 : this.author.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book (");

        sb.append(id);
        sb.append(", ").append(title);
        sb.append(", ").append(author);

        sb.append(")");
        return sb.toString();
    }
}
