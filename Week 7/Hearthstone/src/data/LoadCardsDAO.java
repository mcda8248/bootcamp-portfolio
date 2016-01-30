package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class LoadCardsDAO {
	private static final String BASIC = "WEB-INF/basic.csv";
	private static final String EXPERT = "WEB-INF/expert.csv";
	private static final String NAXX = "WEB-INF/naxx.csv";
	private static final String GVG = "WEB-INF/gvg.csv";
	private static final String BRM = "WEB-INF/brm.csv";
	private static final String TGT = "WEB-INF/tgt.csv";
	private static final String LOE = "WEB-INF/loe.csv";
	private static final String REWARD = "WEB-INF/reward.csv";
	private static final String ALL = "WEB-INF/all.csv";
	private List<Card> basic = new ArrayList<>();
	private List<Card> classic = new ArrayList<>();
	private List<Card> naxx = new ArrayList<>();
	private List<Card> gvg = new ArrayList<>();
	private List<Card> brm = new ArrayList<>();
	private List<Card> tgt = new ArrayList<>();
	private List<Card> loe = new ArrayList<>();
	private List<Card> reward = new ArrayList<>();
	private List<Card> all = new ArrayList<>();

	@Autowired
	private ApplicationContext ac;

	@PostConstruct
	public void init() {

		loadCards(BASIC, basic);
		System.out.println("added basic404");
		loadCards(EXPERT, classic);
		loadCards(NAXX, naxx);
		loadCards(GVG, gvg);
		loadCards(BRM, brm);
		loadCards(TGT, tgt);
		loadCards(LOE, loe);
		loadCards(REWARD, reward);
		loadCards(ALL, all);
	}

	public void loadCards(String s, List<Card> l) {
		try {
			InputStream is = ac.getResource(s).getInputStream();
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String cost = tokens[0];
				String name = tokens[1];
				String user = tokens[2];
				String type = tokens[3];
				String rarity = tokens[4];
				String dust = tokens[5];
				String atk = tokens[6];
				String hp = tokens[7];
				String img = tokens[8];
				int costInt = toInt(cost);
				int dustInt = toInt(dust);
				int atkInt = toInt(atk);
				int hpInt = toInt(hp);

				l.add(new Card(costInt, name, user, type, rarity, dustInt, atkInt, hpInt, img));
			}
		} catch (Exception e) {
			System.out.println("Erroer reading file");
			System.err.println(e);
		}

	}

	public int toInt(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
			return i;
		} catch (Exception e) {
			return i;
		}
	}

	public List<Card> getCardList(String s) {
		switch (s) {
		case "basic":
			return basic;

		case "classic":
			return classic;

		case "naxx":
			return naxx;

		case "gvg":
			return gvg;

		case "brm":
			return brm;

		case "tgt":
			return tgt;

		case "loe":
			return loe;

		case "reward":
			return reward;

		case "all":
			return all;

		default:
			List<Card> error = new ArrayList<>();
			error.add(new Card(-1, "NOOOOOOO", "Error", "Exception", "Hopefully Uncommon", -1, -1, -1,
					"WEB-INF/reward/404.png"));
			return error;
		}
	}

	public List<Card> getCardList(String s, String c) {
		switch (s) {
		case "basic":
			List<Card> basicbyclass = new ArrayList<>();
			for (Card d : basic) {
				if (d.getUser().equals(c)) {
					basicbyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					basicbyclass.add(d);
				}
			}
			return basicbyclass;

		case "classic":
			List<Card> classicbyclass = new ArrayList<>();
			for (Card d : classic) {
				if (d.getUser().equals(c)) {
					classicbyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					classicbyclass.add(d);
				}
			}
			return classicbyclass;

		case "naxx":
			List<Card> naxxbyclass = new ArrayList<>();
			for (Card d : naxx) {
				if (d.getUser().equals(c)) {
					naxxbyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					naxxbyclass.add(d);
				}
			}
			return naxxbyclass;

		case "gvg":
			List<Card> gvgbyclass = new ArrayList<>();
			for (Card d : gvg) {
				if (d.getUser().equals(c)) {
					gvgbyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					gvgbyclass.add(d);
				}
			}
			return gvgbyclass;

		case "brm":
			List<Card> brmbyclass = new ArrayList<>();
			for (Card d : brm) {
				if (d.getUser().equals(c)) {
					brmbyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					brmbyclass.add(d);
				}
			}
			return brmbyclass;

		case "tgt":
			List<Card> tgtbyclass = new ArrayList<>();
			for (Card d : tgt) {
				if (d.getUser().equals(c)) {
					tgtbyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					tgtbyclass.add(d);
				}
			}
			return tgtbyclass;

		case "loe":
			List<Card> loebyclass = new ArrayList<>();
			for (Card d : loe) {
				if (d.getUser().equals(c)) {
					loebyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					loebyclass.add(d);
				}
			}
			return loebyclass;

		case "reward":
			List<Card> rewardbyclass = new ArrayList<>();
			for (Card d : reward) {
				if (d.getUser().equals(c)) {
					rewardbyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					rewardbyclass.add(d);
				}
			}
			return rewardbyclass;

		case "all":
			List<Card> allbyclass = new ArrayList<>();
			for (Card d : all) {
				if (d.getUser().equals(c)) {
					allbyclass.add(d);
				}
				else if (d.getUser().equals("Neutral")){
					allbyclass.add(d);
				}
			}
			return allbyclass;

		default:
			List<Card> error = new ArrayList<>();
			error.add(new Card(-1, "NOOOOOOO", "Error", "Exception", "Hopefully Uncommon", -1, -1, -1,
					"images/reward/404.png"));
			return error;
		}
	}
}