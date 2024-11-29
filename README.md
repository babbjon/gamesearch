# gamesearch

A very small example of renting video games from an online API.

## Installation

Download from github. Everything should be ready.

## Usage

It's easiest to run using leiningen.
    $  lein run
   in the project direcotry.

   At present the project takes no arguments.
   It uses localhost for web traffic.


   It is a proof-of-concept project; as such, it uses atoms to store persistent information. This stands in for a database layer.

### Bugs

At present, there are no known bugs.


### Issues

The GiantBomb api which is referenced in the project returns api data fine with game requests but is giving 403 errors for search requests. The code for the api call is still in the project, but it has been commented out and replaced with some mock data. The search function right now ignores actual parameters and uses the pre-fetched data instead. 

The step for cleansing search terms input by the user was mentioned but not implemented. Any real online search would require full cleansing of data before putting into a URL.

There should be limits on both search terms typed in and number of items allowed to be rented at one time.

### Further Steps

The work flow is very rudimentary. 
Next steps would include:
   A button for removing items from the checkout list
   Better functions for building views - especially when javascript is needed
   
The app at present presumes it is embedded in a larger framework. It starts assuming a user has logged in and is known by the systerm. It also assumed that the Rent button at the end will proceed to other pages that provide that functionality. This is really a snapshot of the system from Initial Search to Rent Button has been Pressed.

The markup is also very rudimentary. It can be improved.


## License

Copyright © 2024

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
