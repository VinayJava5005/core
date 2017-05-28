package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by pradeep on 28/5/17.
 */

class Spider {

    Spider() {

    }

    Spider(int index, int power) {
        this.index = index;
        this.power = power;
    }

    private int index;
    private int power;

    public int getIndex() {
        return index;
    }

    public Spider setIndex(int index) {
        this.index = index;
        return this;
    }

    public int getPower() {
        return power;
    }

    public Spider setPower(int power) {
        this.power = power;
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(this.power);
    }
}

public class MonkChamber {

    private static Queue<Spider> spiderQueue = new LinkedList<>();
    private static Spider minPower = new Spider(Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static Queue<Spider> topFiveSpider = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        method1(br);

        method2(br);
    }

    private static void method2(BufferedReader br) throws IOException {
        String[] firstLine = br.readLine().split(" ");

        int iteration = Integer.parseInt(firstLine[1]);
        populateQueue(br.readLine());
        while (iteration > 0) {

            int maxPower = getMaxPower(Integer.parseInt(firstLine[1]));
            if (maxPower != -1)
                System.out.print(maxPower + " ");
            iteration--;
        }
        spiderQueue.clear();
    }

    private static void method1(BufferedReader br) throws IOException {
        String[] firstLine = br.readLine().split(" ");

        int iteration = Integer.parseInt(firstLine[1]);

        List<Integer> spiders = Arrays.stream(br.readLine().split(" ")).map(power -> Integer.parseInt(power)).collect(Collectors.toList());

        int startIndex = 0;

        int itemsCount = iteration;

        while (iteration > 0) {

            int endIndex = (startIndex + itemsCount) <= spiders.size() ? (startIndex + itemsCount) : spiders.size();
            int itemFetch = 0;

            int maxPowerIndex = -1;

            for (int index = startIndex; index < endIndex; index++) {

                if (spiders.get(index) != -1) {
                    maxPowerIndex = getMaxPowerIndex(spiders, maxPowerIndex, index);
                    itemFetch++;
                }
            }

            if (itemFetch < itemsCount) {
                for (int index = 0; index < startIndex; index++) {
                    if (spiders.get(index) != -1) {
                        maxPowerIndex = getMaxPowerIndex(spiders, maxPowerIndex, index);
                        itemFetch++;
                        if (itemFetch == itemsCount) {
                            startIndex = index + 1;
                            break;
                        }
                    }
                }
            } else {
                startIndex = endIndex;
            }

            if (maxPowerIndex != -1) {
                System.out.print(maxPowerIndex + 1 + " ");

                spiders.set(maxPowerIndex, -1);
            } else {
                break;
            }

            iteration--;
        }
    }

    private static int getMaxPowerIndex(List<Integer> spiders, int maxPowerIndex, int index) {
        if (maxPowerIndex != -1) {
            if (spiders.get(maxPowerIndex) >= spiders.get(index)) {
                int power = spiders.get(index);
                spiders.set(index, power == 0 ? 0 : --power);
            } else {
                int power = spiders.get(maxPowerIndex);
                spiders.set(maxPowerIndex, power == 0 ? 0 : --power);

                maxPowerIndex = index;
            }
        } else {
            maxPowerIndex = index;
        }
        return maxPowerIndex;
    }

    private static int getMaxPower(int selectNumber) {

        int maxPowerIndex = -1;

        while (selectNumber > 0) {

            if (!spiderQueue.isEmpty()) {
                topFiveSpider.offer(spiderQueue.poll());
            } else {
                break;
            }
            selectNumber--;
        }

        if (!topFiveSpider.isEmpty()) {
            Spider maxPowerSpider = topFiveSpider.stream().reduce(minPower, (a, b) -> a.getPower() >= b.getPower() ? a : b);

            if (maxPowerSpider.getPower() != Integer.MIN_VALUE) {
                maxPowerIndex = maxPowerSpider.getIndex();
                while (!topFiveSpider.isEmpty()) {
                    Spider spider = topFiveSpider.poll();

                    if (spider.getIndex() != maxPowerSpider.getIndex()) {
                        int power = spider.getPower();
                        spider.setPower(power == 0 ? power : --power);
                        spiderQueue.offer(spider);
                    }
                }
            }
        }

        topFiveSpider.clear();
        return maxPowerIndex;

    }

    private static void populateQueue(String secondLine) {

        for (String power : secondLine.split(" ")) {
            Spider spider = new Spider();
            int queueSize = spiderQueue.size();
            spider.setPower(Integer.parseInt(power))
                    .setIndex(queueSize == 0 ? 1 : queueSize + 1);
            spiderQueue.offer(spider);
        }

    }
}
