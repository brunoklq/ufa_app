package com.example.ufa

// One room posted by a landlord (later this becomes a database table, Tutorial Six)
data class RoomListing(
    val id: Int,
    val price: Int,            // € per week
    val title: String,
    val distanceKm: Double,
    val roomType: String,      // Bedroom / Kitchen / Bathroom / Living room
    val favourite: Boolean = false
)

val sampleListings = listOf(
    RoomListing(1, 180, "Double room · Rathmines", 0.4, "Bedroom", true),
    RoomListing(2, 220, "Ensuite near Griffith College", 0.9, "Bedroom"),
    RoomListing(3, 150, "Single room · Portobello", 1.6, "Bedroom"),
    RoomListing(4, 260, "Studio with kitchen · Ranelagh", 2.3, "Kitchen"),
    RoomListing(5, 190, "Shared house · Harold's Cross", 2.8, "Living room"),
    RoomListing(6, 310, "Large double · Ballsbridge", 3.5, "Bedroom")
)