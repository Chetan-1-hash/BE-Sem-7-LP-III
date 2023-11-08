// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;

contract Student {
    struct User {
        uint id;
        string name;
    }

    User[] public users;
    uint public nextId = 1;

    function create(string memory name) public {
        users.push(User(nextId, name));
        nextId++;
    }

    function read(uint id) public view returns (uint, string memory) {
        uint index = find(id);
        require(index < users.length, "User does not exist");
        return (users[index].id, users[index].name);
    }

    function update(uint id, string memory name) public {
        uint index = find(id);
        require(index < users.length, "User does not exist");
        users[index].name = name;
    }

    function Delete(uint id) public {
        uint index = find(id);
        require(index < users.length, "User does not exist");
        delete users[index];
    }

    function find(uint id) internal view returns (uint) {
        for (uint i = 0; i < users.length; i++) {
            if (users[i].id == id) {
                return i;
            }
        }
        revert("User does not exist");
    }
}
