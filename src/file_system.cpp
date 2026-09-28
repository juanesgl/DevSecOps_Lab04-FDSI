#include "file_system.h"
#include <iostream>
#include <fstream>

void viewDocument(const std::string& filename) {
    std::string path = "/var/www/html/public_docs/" + filename;
    std::ifstream file(path);
    if(file.is_open()) {
        std::cout << "Reading file contents...\n";
    }
}