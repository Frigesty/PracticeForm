import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork extends TestBase{

    @Test
    void practiceFormTest(){

        String firstName = "Mister",
                lastName = "Human",
                userEmail = "human@gmail.com",
                gender = "Male",
                number = "9997770044",
                year = "1996",
                month = "August",
                day = "02",
                subject = "Maths",
                hobby = "Sports",
                picture = "duck.png",
                address = "Random Address",
                state = "NCR",
                city = "Delhi";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__day--0" + day).click();
        $("#subjectsContainer input").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(userEmail),
                text(gender),
                text(number),
                text(day + " " + month + "," + year),
                text(subject),
                text(hobby),
                text(picture),
                text(address),
                text(state + " " + city)
        );







    }
}
