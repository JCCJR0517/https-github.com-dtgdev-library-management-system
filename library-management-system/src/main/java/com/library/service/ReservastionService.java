package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Member;
import com.example.library.model.Reservation;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.MemberRepository;
import com.example.library.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LoanRepository loanRepository;

    public String reserveBook(Long memberId, Long bookId) {
        // Check if the book exists
        Optional<Book> book = bookRepository.findById(bookId);
        if (!book.isPresent()) {
            return "Book not found.";
        }

        // Check if there are any copies available
        if (loanRepository.countByBookIdAndReturnDateIsNull(bookId) < book.get().getCopiesAvailable()) {
            return "There are still copies available, you can borrow the book instead.";
        }

        // Check if the member exists
        Optional<Member> member = memberRepository.findById(memberId);
        if (!member.isPresent()) {
            return "Member not found.";
        }

        // Create a reservation
        Reservation reservation = new Reservation();
        reservation.setMember(member.get());
        reservation.setBook(book.get());
        reservation.setReservationDate(LocalDate.now());
        reservationRepository.save(reservation);

        return "Book reserved successfully.";
    }

    public List<Reservation> getReservationQueueForBook(Long bookId) {
        return reservationRepository.findByBookId(bookId);
    }
}
