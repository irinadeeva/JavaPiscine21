package day01.ex02;

public class UsersArrayList implements UsersList {
    private static final int DEFAULT_CAPACITY = 10;
    private User[] userArrayList;
    private Integer size;
    private Integer minCapacity;


    public UsersArrayList() {
        this.userArrayList = new User[DEFAULT_CAPACITY];
        this.size = 0;
        this.minCapacity = DEFAULT_CAPACITY;
    }


    @Override
    public boolean addUser(User user) {
        if (minCapacity.equals(size + 1)) {
            grow();
        }
        userArrayList[size++] = user;
        return true;
    }

    @Override
    public User getUserByID(Integer id) throws UserNotFoundException {
        int i = 0;
        while (i < size) {
            User user = userArrayList[i];
            if (id.equals(user.getIdentifier()))
                return user;
            i++;
        }
        throw new UserNotFoundException();
    }

    @Override
    public User UserByIndex(Integer index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return userArrayList[index];
    }

    @Override
    public Integer getNumberOfUsers() {
        return size;
    }

    private void grow() {
        minCapacity = minCapacity + minCapacity / 2;
        User[] temp = new User[minCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = userArrayList[i];
        }
        userArrayList = temp;
    }

}

