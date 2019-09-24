import java.util.Date;

public class StockMarket {

    private String symbol;
    private String series;
    private float open;
    private float high;
    private float low;
    private float close;
    private float last;
    private float prevClose;
    private long totTrdQty;
    private long totTrdVal;
    private Date timestamp;
    private int totalTrades;
    private String isin;

    public StockMarket(String symbol, String series, float open, float high, float low, float close, float last, float prevClose, long totTrdQty, long totTrdVal, Date timestamp, int totalTrades, String isin) {
        this.symbol = symbol;
        this.series = series;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.last = last;
        this.prevClose = prevClose;
        this.totTrdQty = totTrdQty;
        this.totTrdVal = totTrdVal;
        this.timestamp = timestamp;
        this.totalTrades = totalTrades;
        this.isin = isin;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSeries() {
        return series;
    }

    public float getOpen() {
        return open;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public float getClose() {
        return close;
    }

    public float getLast() {
        return last;
    }

    public float getPrevClose() {
        return prevClose;
    }

    public long getTotTrdQty() {
        return totTrdQty;
    }

    public long getTotTrdVal() {
        return totTrdVal;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getTotalTrades() {
        return totalTrades;
    }

    public String getIsin() {
        return isin;
    }
}
