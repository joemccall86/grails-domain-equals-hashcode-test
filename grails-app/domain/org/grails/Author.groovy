package org.grails

class Author {

    static hasMany = [
            books: Book
    ]

    static constraints = {
    }
}
