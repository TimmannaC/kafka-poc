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

    public StockMarket(){
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


    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public void setLast(float last) {
        this.last = last;
    }

    public void setPrevClose(float prevClose) {
        this.prevClose = prevClose;
    }

    public void setTotTrdQty(long totTrdQty) {
        this.totTrdQty = totTrdQty;
    }

    public void setTotTrdVal(long totTrdVal) {
        this.totTrdVal = totTrdVal;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setTotalTrades(int totalTrades) {
        this.totalTrades = totalTrades;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }
}
