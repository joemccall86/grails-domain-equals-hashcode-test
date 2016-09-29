package gorm.unit.behaviors


import grails.test.mixin.integration.Integration
import grails.transaction.*
import org.grails.Author
import org.grails.Book
import spock.lang.*

@Integration
@Rollback
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
