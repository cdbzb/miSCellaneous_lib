
/*
	This file is part of miSCellaneous, a program library for SuperCollider 3

	Created: 2017-05-21, version 0.20
	Copyright (C) 2009-2018 Daniel Mayer
	Email: 	daniel-mayer@email.de
	URL:	http://daniel-mayer.at

	This program is free software; you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation; either version 2 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program; if not, write to the Free Software
	Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/


+TempoClock {

	miSC_getPhaseFromNextTimeOnGrid { arg quant = 1, nextTimeOnGrid = 0;
		^nextTimeOnGrid - baseBarBeat - 
			roundUp(this.beats - baseBarBeat - ((nextTimeOnGrid - baseBarBeat) % quant), quant);
	}
	
	miSC_getPhaseFromTimeToNextBeat { arg quant = 1, timeToNextBeat = 0;
		^this.miSC_getPhaseFromNextTimeOnGrid(quant, timeToNextBeat + this.beats);
	}
}