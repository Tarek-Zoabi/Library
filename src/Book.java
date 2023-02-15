public class Book {
    private int bookCode;
    private String title;
    private String writer;
    private int yearOfpup;
    private int numOfPages;

    public Book(int bookCode, String title, String writer, int yearOfpup, int numOfPages) {
        this.bookCode = bookCode;
        this.title = title;
        this.writer = writer;
        this.yearOfpup = yearOfpup;
        this.numOfPages = numOfPages;
    }



    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getYearOfpup() {
        return yearOfpup;
    }

    public void setYearOfpup(int yearOfpup) {
        this.yearOfpup = yearOfpup;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
    public boolean isEqual(Book b){
        if (bookCode==b.bookCode && this.title==b.title && this.writer==b.writer && this.yearOfpup==b.yearOfpup && this.numOfPages==b.numOfPages)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookCode=" + bookCode +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", yearOfpup=" + yearOfpup +
                ", numOfPages=" + numOfPages +
                '}';
    }
}
