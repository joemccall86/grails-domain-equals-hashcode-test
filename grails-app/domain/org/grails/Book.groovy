package org.grails

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Book {

    static constraints = {
    }

    static belongsTo = [
            author: Author
    ]
}
