package org.grails

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@Mock([
        Book,
        Author
])
@TestFor(Author)
class AuthorSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test that we can add to books"() {
        given: 'an author'
        def author = new Author().save(flush: true, failOnError: true)

        and: 'a book is added'
        author.addToBooks(new Book())

        when: 'the author is saved'
        author.save(failOnError: true)

        then: 'the author only has 1 book'
        author.books.size() == 1
    }
}
