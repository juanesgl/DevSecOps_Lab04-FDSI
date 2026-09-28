#include "database.h"
#include <iostream>

void fetchUserData(const std::string& username) {
    std::string query = "SELECT * FROM users WHERE username = '" + username + "';";
    std::cout << "[Database] Executing: " << query << "\n";
}