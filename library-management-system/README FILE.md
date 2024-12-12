# Library Management System - Changes Overview

## New Feature - Book Reservation

In this update, a new feature was added to the Library Management System that allows members to reserve a book if all copies are currently borrowed. The feature includes an API endpoint that handles the reservation process. When a member attempts to borrow a book and all copies are unavailable, they can opt to reserve the book. If the book is fully borrowed, the system will create a reservation for the member, adding them to a queue. This feature ensures that members can still have access to the book once a copy becomes available. Additionally, appropriate responses are returned based on the availability of the book and the member’s status.

## Changes to `data.sql`

Alongside this feature, the `data.sql` file located in `src/main/resources` was extended to include new data. Five new books were added with diverse titles, authors, ISBNs, published years, and available copies. Additionally, three new members were added with unique names, emails, and membership dates. Three loan records were also inserted to associate members with borrowed books. These updates provide a more robust dataset for testing the system's functionality.

To apply these changes, the `data.sql` file needs to be modified accordingly, and the Spring Boot application should be rebuilt and restarted to load the new data. The system will automatically insert the new books, members, and loan records into the database on startup. Once the application is running, users can verify the changes by querying the books, members, and loan records through the H2 console or by using the existing API endpoints.

## Summary

In summary, this update enhances the Library Management System with a book reservation feature and provides a richer dataset for testing and validation. The changes ensure that members have a smoother experience even when the desired books are unavailable, and the expanded dataset makes the system more dynamic for real-world usage.
