package com.hermes.training.spring.quotes.data;

import com.hermes.training.spring.quotes.data.quote.Quote;
import com.hermes.training.spring.quotes.data.user.User;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static List<Quote> getBootstrapQuotes() {
        return feedQuotes();
    }

    public static List<User> getBootstrapUsers() {
        return feedUsers();
    }

    private static List<Quote> feedQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("The trouble with having an open mind, of course, is that people will insist on coming along and trying to put things in it.", "Terry Pratchett", "Diggers"));
        quotes.add(new Quote("Give a man a fire and he's warm for a day, but set fire to him and he's warm for the rest of his life.", "Terry Pratchett", "Jingo"));
        quotes.add(new Quote("Some humans would do anything to see if it was possible to do it. If you put a large switch in some cave somewhere, with a sign on it saying 'End-of-the-World Switch. PLEASE DO NOT TOUCH', the paint wouldn't even have time to dry.", "Terry Pratchett", "Thief of Time"));
        quotes.add(new Quote("It is said that your life flashes before your eyes just before you die. That is true, it's called Life.", "Terry Pratchett", "The Last Continent"));
        quotes.add(new Quote("Stories of imagination tend to upset those without one.", "Terry Pratchett", ""));
        quotes.add(new Quote("Why do you go away? So that you can come back. So that you can see the place you came from with new eyes and extra colors. And the people there see you differently, too. Coming back to where you started is not the same as never leaving.", "Terry Pratchett", "A Hat Full of Sky"));
        quotes.add(new Quote("If cats looked like frogs we'd realize what nasty, cruel little bastards they are. Style. That's what people remember.", "Terry Pratchett", "Lords and Ladies"));
        quotes.add(new Quote("In ancient times cats were worshipped as gods; they have not forgotten this.", "Terry Pratchett", ""));
        quotes.add(new Quote("Time is a drug. Too much of it kills you.", "Terry Pratchett", "Small Gods"));
        quotes.add(new Quote("Wisdom comes from experience. Experience is often a result of lack of wisdom.", "Terry Pratchett", ""));
        quotes.add(new Quote("In the beginning there was nothing, which exploded.", "Terry Pratchett", "Lords and Ladies"));
        quotes.add(new Quote("I meant,\" said Ipslore bitterly, \"what is there in this world that truly makes living worthwhile?\" Death thought about it. CATS, he said eventually. CATS ARE NICE.", "Terry Pratchett", "Sourcery"));
        quotes.add(new Quote("It's not worth doing something unless someone, somewhere, would much rather you weren't doing it.", "Terry Pratchett", ""));
        quotes.add(new Quote("Light thinks it travels faster than anything but it is wrong. No matter how fast light travels, it finds the darkness has always got there first, and is waiting for it.", "Terry Pratchett", "Reaper Man"));
        quotes.add(new Quote("DON'T THINK OF IT AS DYING, said Death. JUST THINK OF IT AS LEAVING EARLY TO AVOID THE RUSH.", "Terry Pratchett", "Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch"));
        quotes.add(new Quote("If you have enough book space, I don't want to talk to you.", "Terry Pratchett", ""));
        quotes.add(new Quote("Five exclamation marks, the sure sign of an insane mind.", "Terry Pratchett", "Reaper Man"));
        quotes.add(new Quote("God does not play dice with the universe; He plays an ineffable game of His own devising, which might be compared, from the perspective of any of the other players [i.e. everybody], to being involved in an obscure and complex variant of poker in a pitch-dark room, with blank cards, for infinite stakes, with a Dealer who won't tell you the rules, and who smiles all the time.", "Terry Pratchett", "Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch"));
        quotes.add(new Quote("I'll be more enthusiastic about encouraging thinking outside the box when there's evidence of any thinking going on inside it.", "Terry Pratchett", ""));
        quotes.add(new Quote("And what would humans be without love?\" RARE, said Death.", "Terry Pratchett", "Sourcery"));
        quotes.add(new Quote("No! Please! I'll tell you whatever you want to know!\" the man yelled. \"Really?\" said Vimes. \"What's the orbital velocity of the moon?\" \"What?\" \"Oh, you'd like something simpler?", "Terry Pratchett", "Night Watch"));
        quotes.add(new Quote("Real stupidity beats artificial intelligence every time.", "Terry Pratchett", "Hogfather"));
        quotes.add(new Quote("There is a rumour going around that I have found God. I think this is unlikely because I have enough difficulty finding my keys, and there is empirical evidence that they exist.", "Terry Pratchett", ""));
        quotes.add(new Quote("It would seem that you have no useful skill or talent whatsoever,\" he said. \"Have you thought of going into teaching?", "Terry Pratchett", "Mort"));
        quotes.add(new Quote("Just erotic. Nothing kinky. It's the difference between using a feather and using a chicken.", "Terry Pratchett", "Eric"));
        quotes.add(new Quote("Coming back to where you started is not the same as never leaving.", "Terry Pratchett", "A Hat Full of Sky"));
        quotes.add(new Quote("A good bookshop is just a genteel Black Hole that knows how to read.", "Terry Pratchett", "Guards! Guards!"));
        quotes.add(new Quote("I'd rather be a rising ape than a falling angel.", "Terry Pratchett", ""));
        quotes.add(new Quote("If you trust in yourself. . .and believe in your dreams. . .and follow your star. . . you'll still get beaten by people who spent their time working hard and learning things and weren't so lazy.", "Terry Pratchett", "The Wee Free Men "));
        return quotes;
    }

    private static List<User> feedUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("administration@quotes.com", "admin", "admin"));
        users.add(new User("Yannick", "Bruyninckx", "yannick.bruyninckx@hermes-ecs.com", "moussecp", "abracadabra"));
        users.add(new User("Guillaume", "Lincé", "guillaume.lince@hermes-ecs.com", "glince", "glinceFTW"));
        users.add(new User("Etienne", "Martel", "etienne.martel@hermes-ecs.com", "eti1", "monmotdepasseestsuperlongetcomplique"));
        return users;
    }
}
