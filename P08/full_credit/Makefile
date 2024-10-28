CXXFLAGS += --std=c++20

all: hello_me hello_all

hello_me: hello_me.cpp
	$(CXX) $(CXXFLAGS) hello_me.cpp -o hello_me

hello_all: hello_all.cpp
	$(CXX) $(CXXFLAGS) hello_all.cpp -o hello_all

clean:
	-rm -f *.o *.gch *~ a.out hello_me hello_all
