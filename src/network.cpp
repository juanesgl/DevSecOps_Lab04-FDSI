#include "network.h"
#include <iostream>
#include <cstdlib>

void executeNetworkCheck(const std::string& targetIp) {
    std::string cmd = "ping -c 3 " + targetIp;
    system(cmd.c_str()); 
}