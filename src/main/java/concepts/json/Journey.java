package concepts.json;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Journey {

    private BigInteger id;

    private int radarId;

    private String registrationNumber;

    private int totalDistance;

    private String arrivalStation;
    private String departureStation;

    private LocalDateTime sta;

    private LocalDateTime std;

    private LocalDateTime eta;

    private LocalDateTime etd;

    private LocalTime averageDelay;

    private LocalTime averageTime;

    private String squawk;

    private boolean emergencySituation;

    private String alertMessage;

    private Flight flightDetail;

    LocalDateTime createdOn;

    LocalDateTime lastUpdated;

    public Journey() {
        super();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getRadarId() {
        return radarId;
    }

    public void setRadarId(int radarId) {
        this.radarId = radarId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public LocalDateTime getSta() {
        return sta;
    }

    public void setSta(LocalDateTime sta) {
        this.sta = sta;
    }

    public LocalDateTime getStd() {
        return std;
    }

    public void setStd(LocalDateTime std) {
        this.std = std;
    }

    public LocalDateTime getEta() {
        return eta;
    }

    public void setEta(LocalDateTime eta) {
        this.eta = eta;
    }

    public LocalDateTime getEtd() {
        return etd;
    }

    public void setEtd(LocalDateTime etd) {
        this.etd = etd;
    }

    public LocalTime getAverageDelay() {
        return averageDelay;
    }

    public void setAverageDelay(LocalTime averageDelay) {
        this.averageDelay = averageDelay;
    }

    public LocalTime getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(LocalTime averageTime) {
        this.averageTime = averageTime;
    }

    public String getSquawk() {
        return squawk;
    }

    public void setSquawk(String squawk) {
        this.squawk = squawk;
    }

    public boolean isEmergencySituation() {
        return emergencySituation;
    }

    public void setEmergencySituation(boolean emergencySituation) {
        this.emergencySituation = emergencySituation;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public Flight getFlightDetail() {
        return flightDetail;
    }

    public void setFlightDetail(Flight flightDetail) {
        this.flightDetail = flightDetail;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
