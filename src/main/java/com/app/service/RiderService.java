package com.app.service;

import com.app.enities.Rider;

import java.util.List;

public interface RiderService {

    Rider getRiderDetails(String id);

    Rider AddRider(Rider newRider);

    List<Rider> getAllRiders();

    String deleteARider(String id);
}
