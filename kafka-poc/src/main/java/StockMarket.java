import javax.swing.*;
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
    private float totTrdQty;
    private float totTrdVal;
    private Date timestamp;
    private float totalTrades;
    private String isin;

    public StockMarket(){
    }


    public static StockMarket FindLargetValue(StockMarket obj1, StockMarket obj2){
        System.out.println("************ Inside the FindLargestValue method ************");
            if (obj1.getTotTrdVal() >= obj2.getTotTrdVal())
                return obj1;
            return obj2;
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

    public float getTotTrdQty() {
        return totTrdQty;
    }

    public float getTotTrdVal() {
        return totTrdVal;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public float getTotalTrades() {
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

    public void setTotTrdQty(float totTrdQty) {
        this.totTrdQty = totTrdQty;
    }

    public void setTotTrdVal(float totTrdVal) {
        this.totTrdVal = totTrdVal;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setTotalTrades(float totalTrades) {
        this.totalTrades = totalTrades;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Override
    public String toString() {
        return "StockMarket{" +
                "symbol='" + symbol + '\'' +
                ", series='" + series + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", last=" + last +
                ", prevClose=" + prevClose +
                ", totTrdQty=" + totTrdQty +
                ", totTrdVal=" + totTrdVal +
                ", timestamp=" + timestamp +
                ", totalTrades=" + totalTrades +
                ", isin='" + isin + '\'' +
                '}';
    }
}
