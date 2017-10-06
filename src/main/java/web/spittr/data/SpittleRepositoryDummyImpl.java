package web.spittr.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepositoryDummyImpl implements SpittleRepository {

    private static List<Spittle> spittles = new ArrayList<>();
    static {
        spittles.add(new Spittle("message", new Date(), 25.0, 30.0));
        spittles.add(new Spittle("message2", new Date(), 25.0, 30.0));
        spittles.add(new Spittle("message3", new Date(), 25.0, 30.0));
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return spittles;
    }

    @Override
    public Spittle findOne(long id) {
        return spittles.get(((int)id)%spittles.size());
    }
}