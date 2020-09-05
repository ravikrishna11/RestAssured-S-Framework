@FunctionalTest
Feature: Library Management

@Get_Book
Scenario Outline: Get Book Details by id
Given Create Book entry with "<bookName>","<authorId>","<publisherId>","<authorName>","<publisherName>","<genre>","<price>","<numberOfPages>"
Then Get the book details using Book id
Then Get the book details using Publisher id
Then Get the book details using Author id
#Then Delete the Book details by Book id

Examples:
| bookName | authorId | publisherId | authorName | publisherName | genre | price | numberOfPages |
| Ram | 1 | 1 | authorone | publishertee | Action | 200 | 200 |
| Suresh | 2 | 2 | authortwo | publishertaa | Action | 200 | 200 |

@Create_Publisher
Scenario Outline: Create Publisher entry
Then Create Publisher entry with "<publisherName>","<address>","<country>"
Then Delete the publisher details by publisher id

Examples:
| publisherName | address | country |
| Suresh | 12 th | USSR |
| Rajesh | 12 th | USSR |

@Create_Author
Scenario Outline: Create Author entry
Then Create Author entry with "<Name>","<address>","<country>"
Then Delete the Author details by Author id

Examples:
| Name | address | country |
| authorthree | 12 th | USSR |
| authorfour | 12 th | USSR |


@Create_Customer
Scenario Outline: Create Customer entry
Then Create Customer entry with "<name>","<address>","<country>"
Then Create Booking using bookID and CustomerID
Then Save Billing entry with "<billingAddress>","<bookingCost>","<zipzode>","<state>"
Then Find Number of Books hold by customer using CustomerID


Examples:
| name | address | country | billingAddress | bookingCost | zipzode | state |
| Sura | 15 th | USSR | 78 th | 250 | 10001 | NY |
| Ryutt | 89 th | USSR | 45 rt | 150 | 48001 | MI |